package test;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.jsonschema.*;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

@Path("/drools/{spreadsheetId}")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    public SpreadsheetResponseObj getSpreadsheet(
            @PathParam("spreadsheetId") long spreadsheetId)
        throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        try {

            // BUild your response here.
            SpreadsheetResponseObj responseObj = new SpreadsheetResponseObj();

            // sampleheader is supposed to be a description of the pojo.
            // this is better served as HeaderService(pojo).  See the sampleheader
            // this is a dirty hack.  Better is to annotate the pjo with jsr 303.
            responseObj.header        = new PojoSampleHeader().getHeader();
            // simple data creator.  purely test
            responseObj.data          = PojoSample.createTest(20);
            // the id per the spec
            responseObj.spreadsheetId = spreadsheetId;

            return responseObj;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @PUT
	@Consumes(MediaType.APPLICATION_JSON)
    public SpreadsheetResponseObj persistSpreadsheet(
            @PathParam("spreadsheetId") long spreadsheetId,
            SpreadsheetResponseObj responseObj)
        throws Exception {

        // Dump the contents to console
        System.out.println(toJson(responseObj));

        // do some work -- persist back to POI.
        // POIService.persist(responseObj);

        // return the same obj back to source.
        return responseObj;


    }

    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(obj).toString();
    }


    public static <A> A fromJson(String jsonString, Class<A> clazz) {
        try {
            return new ObjectMapper().readValue(jsonString, clazz);
        } catch(Throwable t) {
            throw new RuntimeException(t);
        }
    }


    public static class SpreadsheetResponseObj{
        public List header;
        public List data;
        public long spreadsheetId;
    }
}
