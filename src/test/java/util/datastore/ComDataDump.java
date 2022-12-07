package util.datastore;

import io.restassured.response.Response;
import lombok.Getter;
import model.httpbin.GETResponse;
import model.httpbin.POSTResponse;

import java.time.Instant;

import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

/**
 * Class contains list of variables that will be stored in thread local variables "DATA_DUMP_COM".
 */

@Getter
public class ComDataDump extends DataStore<ComDataDump> {


    private String example;
    private Response response;
    private GETResponse getResponse;

    private POSTResponse postResponse;
    private Instant before;
    private Instant after;

    public ComDataDump() {
        super(DATA_DUMP_COM);
    }

    public void setGetResponse(GETResponse response) {
        this.getResponse = response;
        writeToThread();
    }

    public void setResponse(Response response) {
        this.response = response;
        writeToThread();
    }
    public void setPostResponse(POSTResponse response) {
        this.postResponse = response;
        writeToThread();
    }

    public Instant getBefore() {
        return before;
    }

    public void setBefore(Instant before) {
        this.before = before;
    }

    public Instant getAfter() {
        return after;
    }

    public void setAfter(Instant after) {
        this.after = after;
    }

    /**
     * Set data to thread local variable DATA_DUMP_COM.
     *
     * @param example -exmaple env.
     */
    public void setExample(String example) {
        this.example = example;
        //this method is mandatory for writing to local thread var.
        writeToThread();
    }
}
