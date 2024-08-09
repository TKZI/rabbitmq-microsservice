package br.com.tkzi.consumer;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler.DefaultExceptionStrategy;

public class CustomErrorStrategy extends DefaultExceptionStrategy{
	
	@Override
	public boolean isFatal(Throwable t) {
		
		return super.isFatal(t);
	} //definir qual exception é fatal para não retornar para fila sem o tratamento

}
