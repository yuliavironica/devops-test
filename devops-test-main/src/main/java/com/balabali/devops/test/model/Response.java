package com.balabali.devops.test.model;

import lombok.Data;

/**
 * Response
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @since 0.0.1
 */
@Data
public class Response {

    /**
     * Message
     */
    private String message;

    /**
     * Success
     */
    private Boolean success;

    /**
     * Data
     */
    private Object data;

    public Response(
        String message,
        boolean success,
        Object data
    ) {
        this.message = message;
        this.success = success;
        this.data = data;
    }
}
