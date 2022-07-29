import java.util.HashSet;
import java.util.Set;

public class LoadBalancer {

    private Set<String> addresses;

    public LoadBalancer ( ) {
        addresses = new HashSet<String>();
    }

    public synchronized void registerInstances(String address) throws Exception{
        if (address.contains(address)) {
            throw new Exception("Address already exist");
        }
        else if (addresses.size()>=10) {
            throw new Exception("To many Instances");
        }else {
            addresses.add(address);
        }
    }

    public int getAddressesSize() {
        return addresses.size();
    }

}
