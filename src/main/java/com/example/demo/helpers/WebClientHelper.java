package com.example.demo.helpers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Component
public class WebClientHelper {
  @Value("${connect.timeout}")
  private Integer connectTimeout;

  @Value("${read.timeout}")
  private Integer readTimeout;

  private WebClient.Builder builder;

  public WebClientHelper builder() {
    this.builder = WebClient.builder();

    TcpClient tcpClient = TcpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, this.connectTimeout).doOnConnected(
            connection -> connection.addHandlerLast(new ReadTimeoutHandler(readTimeout)));
    this.builder.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)));

    return this;
  }

  public WebClientHelper headers(Map<String, String> headers) {
    headers.forEach((key, value) -> builder.defaultHeader(key, value));
    return this;
  }

  public WebClient build() {
    return builder.build();
  }
}
