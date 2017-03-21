package dto.hello;

/**
 * Created by rajjasti on 3/20/17.
 */
public class HelloResponse {

    private String name;

    public HelloResponse(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
