# Micrometer throw NullPointerException

This is a project to reproduce the issue described [here](https://github.com/micrometer-metrics/micrometer/issues/2203)


## Steps to reproduce

1 - Run the main method: com.example.demo.DemoApplication.main

2 - Using your browser open the url: http://localhost:8080/home

3 - Check your console log, you will have the exception below:



```
java.lang.NullPointerException: null
	at io.micrometer.core.instrument.binder.jetty.JettyClientMetrics.lambda$onQueued$2(JettyClientMetrics.java:64) ~[micrometer-core-1.5.1.jar:1.5.1]
	at org.eclipse.jetty.client.HttpRequest$16.onComplete(HttpRequest.java:617) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.ResponseNotifier.notifyComplete(ResponseNotifier.java:218) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.ResponseNotifier.notifyComplete(ResponseNotifier.java:210) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.HttpReceiver.terminateResponse(HttpReceiver.java:543) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.HttpReceiver.terminateResponse(HttpReceiver.java:523) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.HttpReceiver.responseSuccess(HttpReceiver.java:486) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.http.HttpReceiverOverHTTP.messageComplete(HttpReceiverOverHTTP.java:326) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.http.HttpParser.handleContentMessage(HttpParser.java:580) ~[jetty-http-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.http.HttpParser.parseContent(HttpParser.java:1697) ~[jetty-http-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.http.HttpParser.parseNext(HttpParser.java:1526) ~[jetty-http-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.http.HttpReceiverOverHTTP.parse(HttpReceiverOverHTTP.java:200) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.http.HttpReceiverOverHTTP.process(HttpReceiverOverHTTP.java:141) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.http.HttpReceiverOverHTTP.receive(HttpReceiverOverHTTP.java:75) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.http.HttpChannelOverHTTP.receive(HttpChannelOverHTTP.java:133) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.client.http.HttpConnectionOverHTTP.onFillable(HttpConnectionOverHTTP.java:156) ~[jetty-client-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:311) ~[jetty-io-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:103) ~[jetty-io-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.io.ChannelEndPoint$1.run(ChannelEndPoint.java:104) ~[jetty-io-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:806) ~[jetty-util-9.4.29.v20200521.jar:9.4.29.v20200521]
	at org.eclipse.jetty.util.thread.QueuedThreadPool$Runner.run(QueuedThreadPool.java:938) ~[jetty-util-9.4.29.v20200521.jar:9.4.29.v20200521]
	at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
```
