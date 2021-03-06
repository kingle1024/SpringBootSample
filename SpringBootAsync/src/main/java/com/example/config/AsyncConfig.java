package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("heowc-async-");
		executor.initialize();
		return executor;
	}

//	@Override
//	public Executor getAsyncExecutor() {
//		return new SimpleAsyncTaskExecutor("heowc-async-");
//	}

//	@Bean
//	public AsyncRestTemplate getAsyncRestTemplate() {
//		return new AsyncRestTemplate();
//	}

	@Bean
	public AsyncRestTemplate getAsyncRestTemplate() {
//		return new AsyncRestTemplate(new Netty4ClientHttpRequestFactory());
        return new AsyncRestTemplate(new HttpComponentsAsyncClientHttpRequestFactory());
	}
}
