package com.vcc.netstage2.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.vcc.netstage2.webservice.InputDeclaration;
import com.vcc.netstage2.webservice.OutputDeclaration;
import com.vcc.netstage2.webservice.POC_WebServiceInterface;

public class RouteDeclaration extends RouteBuilder {

	private String uri = "cxf:/VCC_NETSTAGE?serviceClass=" + POC_WebServiceInterface.class.getName();
	
	@Override
	public void configure() throws Exception {
		
		from(uri)
		.to("log:input")
        // send the request to the route to handle the operation
        // the name of the operation is in that header
        .recipientList(simple("direct:${header.operationName}"));
		
		from("direct:sendDeclaration")
		.log("::::: Recive Declaration ")
		.to("log: Saving InBound repository ")
		.process( new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				/*get the id of the input*/
	               InputDeclaration input = exchange.getIn().getBody(InputDeclaration.class);
		           String id = input.getId();
		           System.out.println("Saving InBound id:"+input.getId()+" BorderOffice:"+input.getBorder_office()+" Export code:"+input.getCountry_export_code());
		           
	               exchange.setProperty("todynamic", "log:output{body}");
			}
		})
		.to("log: Saving Invoice table ")
		.process( new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				/*get the id of the input*/
	               InputDeclaration input = exchange.getIn().getBody(InputDeclaration.class);
		           String id = input.getId();
		           System.out.println("Saving Invoice table id:"+input.getId()+" BorderOffice:"+input.getBorder_office()+" Export code:"+input.getCountry_export_code());
		           
	               exchange.setProperty("todynamic", "log:output{body}");
			}
		})
		.to("log: Routing request ")
		.process( new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				/*get the id of the input*/
	               InputDeclaration input = exchange.getIn().getBody(InputDeclaration.class);
		           String id = input.getId();
		           System.out.println("Routing request id:"+input.getId()+" BorderOffice:"+input.getBorder_office()+" Export code:"+input.getCountry_export_code());
		           
	               exchange.setProperty("todynamic", "log:output{body}");
			}
		})
		.to("log: Generate output and save on OutBound ")
		.process(new Processor() {
            public void process(Exchange exchange) throws Exception {
               /*get the id of the input*/
               InputDeclaration input = exchange.getIn().getBody(InputDeclaration.class);
	           String id = input.getId();
	           System.out.println("Generate output and save on OutBound id:"+input.getId()+" BorderOffice:"+input.getBorder_office()+" Export code:"+input.getCountry_export_code());
	            /*set reply including the id*/
               OutputDeclaration output = new OutputDeclaration();
               output.setStatus("OK");
               output.setId(input.getId());
               /*String route=getRouteValueDB(input.getfName());
               System.out.println("Route "+route);
               exchange.getOut().setHeader("sample", route);*/
               exchange.getOut().setBody(output);
               exchange.setProperty("todynamic", "log:output{body}");
           }
       }).to("log:{body}")
	   .log("::::: End of Declaration {body}");
	}

}
