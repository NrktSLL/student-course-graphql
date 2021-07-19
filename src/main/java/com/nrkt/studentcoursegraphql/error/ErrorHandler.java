package com.nrkt.studentcoursegraphql.error;

import com.netflix.graphql.dgs.exceptions.DefaultDataFetcherExceptionHandler;
import com.netflix.graphql.types.errors.ErrorType;
import com.netflix.graphql.types.errors.TypedGraphQLError;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler implements DataFetcherExceptionHandler {
    private final DefaultDataFetcherExceptionHandler defaultHandler = new DefaultDataFetcherExceptionHandler();

    @Override
    public DataFetcherExceptionHandlerResult onException(DataFetcherExceptionHandlerParameters handlerParameters) {
        if (handlerParameters.getException() instanceof NotFoundError) {
            return DataFetcherExceptionHandlerResult.newResult()
                    .error(errorBuilder(handlerParameters))
                    .build();
        } else {
            return defaultHandler.onException(handlerParameters);
        }
    }

    private TypedGraphQLError errorBuilder(DataFetcherExceptionHandlerParameters handlerParameters) {
        return TypedGraphQLError.newBuilder().errorType(ErrorType.BAD_REQUEST)
                .message(handlerParameters.getException().getMessage())
                .path(handlerParameters.getPath())
                .build();
    }
}