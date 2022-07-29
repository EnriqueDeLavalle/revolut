import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LoadBalancerTest extends TestCase {

    public static final String ADDRESS_ALREADY_EXIST_MSG = "Address already exist";
    private LoadBalancer loadBalancer = new LoadBalancer();

    public static final String TO_MANY_INSTANCES_MSG = "To many Instances";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    public void registerAddressesTest () {
        try {
            loadBalancer.registerInstances("172.0.0.1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(loadBalancer.getAddressesSize(),1);

    }


    public void testRegisterMoreThan10Addresses() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage(TO_MANY_INSTANCES_MSG);
        try {
            loadBalancer.registerInstances("172.0.0.1");
            loadBalancer.registerInstances("172.0.0.2");
            loadBalancer.registerInstances("172.0.0.3");
            loadBalancer.registerInstances("172.0.0.4");
            loadBalancer.registerInstances("172.0.0.5");
            loadBalancer.registerInstances("172.0.0.6");
            loadBalancer.registerInstances("172.0.0.7");
            loadBalancer.registerInstances("172.0.0.8");
            loadBalancer.registerInstances("172.0.0.9");
            loadBalancer.registerInstances("172.0.0.10");
            loadBalancer.registerInstances("172.0.0.11");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(expected = Exception.class)
    public void testRegisterRepitedAddresses () {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage(ADDRESS_ALREADY_EXIST_MSG);
        try {
            loadBalancer.registerInstances("172.0.0.1");
            loadBalancer.registerInstances("172.0.0.1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
