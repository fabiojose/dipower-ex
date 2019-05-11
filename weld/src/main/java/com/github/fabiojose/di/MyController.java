package com.github.fabiojose.di;

import java.nio.charset.Charset;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;

import com.github.fabiojose.di.core.MyCoreClass;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author fabiojose
 *
 */
@ApplicationScoped
@Slf4j
public class MyController extends ChannelInboundHandlerAdapter {
    
    @Inject
    private MyCoreClass core;

    @Override
    @ActivateRequestContext
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	
        ByteBuf in = (ByteBuf) msg;
        try {
        	
            log.info("New message received: {}",
            	in.toString(Charset.defaultCharset()));
            
            log.info("My core class instance: {}", core);
            
            log.info("My core class result: {}", core.dummy());
            
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
