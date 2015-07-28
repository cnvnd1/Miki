package com.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration_LocationList {
	
	

	@Bean(name={"fileWrite"})
	FlatFileItemWriter<LocationList> fileWrite(){
		FlatFileItemWriter<LocationList> fileWrite = new FlatFileItemWriter<LocationList>();
		fileWrite.setResource(new ClassPathResource("afterlocationList.csv"));
		DelimitedLineAggregator<LocationList> aggregator = new DelimitedLineAggregator<LocationList>();
		aggregator.setDelimiter(",");
		aggregator.setFieldExtractor(new FieldExtractor<LocationList>() {
			
			@Override
			public Object[] extract(LocationList item) {
				String[] names= {"mNumber","userId","mTime","beaconId"};
				return names;
			}
		});
		fileWrite.setLineAggregator(aggregator);
		return fileWrite;
			
	}
	
	
    // tag::readerwriterprocessor[]
    @Bean
    public ItemReader<LocationList> reader() {
        FlatFileItemReader<LocationList> reader = new FlatFileItemReader<LocationList>();
        reader.setResource(new ClassPathResource("locationList.csv"));
        reader.setLineMapper(new DefaultLineMapper<LocationList>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "userId", "mTime","beaconId" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<LocationList>() {{
                setTargetType(LocationList.class);
            }});
        }});
        return reader;
    }
   	
   
    
    @Bean
    public ItemProcessor<LocationList, LocationList> processor() {
        return new LocationItemprocessor();
    }

    @Bean
    public ItemWriter<LocationList> writer(DataSource dataSource) {
        JdbcBatchItemWriter<LocationList> writer = new JdbcBatchItemWriter<LocationList>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<LocationList>());
        writer.setSql("INSERT INTO locationList (mNumber,userId, mTime,beaconId) VALUES (mnumber_seq.nextval,:userId, :mTime, :beaconId)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1, JobExecutionListener listener) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<LocationList> reader,
            ItemWriter<LocationList> writer, ItemProcessor<LocationList, LocationList> processor) {
        return stepBuilderFactory.get("step1")
                .<LocationList, LocationList> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
    // end::jobstep[]

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
}