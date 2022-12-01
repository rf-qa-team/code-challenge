package util.datastore;

import io.restassured.response.Response;
import lombok.Getter;
import model.httpbin.GETResponse;

import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

/**
 * Class contains list of variables that will be stored in thread local variables "DATA_DUMP_COM".
 */

@Getter
public class ComDataDump extends DataStore<ComDataDump> {


    private String example;
    private Response response;
    private GETResponse getResponse;

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
