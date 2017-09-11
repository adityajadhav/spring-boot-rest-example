package com.aj.todoapp.rest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.aj.todoapp.data.entity.RestErrorInfoEntity;
import com.aj.todoapp.framework.exception.ResourceNotFoundException;

public class AbstractRestHandler implements ApplicationEventPublisherAware {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	protected ApplicationEventPublisher eventPublisher;

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody RestErrorInfoEntity handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request, HttpServletResponse response) {
		log.info("ResourceNotFoundException handler:" + ex.getMessage());

		return new RestErrorInfoEntity(ex, "Sorry, Resource does not exist");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

		this.eventPublisher = applicationEventPublisher;

	}

	public static <T> T checkResourceFound(final T resource) {
		if (resource == null) {
			throw new ResourceNotFoundException("Resource not found");
		}
		return resource;
	}

}
