1.Run the application with MySpringAppApplication.java
2.com.biswo.myspringapp.activators and com.biswo.myspringapp.model.State has spring integration code.
3.Its a simple application which basically fetches states of a country.
4. CountryInboundAdapter inbound adapters fetches a courty randomly and sends for further processing.
5.SourceStateServiceActivator fetches the states List<States> from the message it receives.
6.Splitter splits it to individuals states and sends for futher processing.
7.Two service activators are part of chain.
8. I have put thread sleep in ServiceActivatorOne and ServiceActivatorTwo.
9.<int:channel id="stateChannel">
		<int:queue capacity="1" />
	</int:channel>
Size is one. So I am expecting retry logic needs to trigger. Since queue size is one and all other messages are trying to 
push to queue. After 6 secs it should go to error channel.
