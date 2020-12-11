package order8082.demo.test;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.stereotype.Component;

import java.util.List;

public class TestImplTwo implements TestDefault {
    public TestImplTwo() {
        System.out.println("\n+testwo\n");
    }

    @Override
    public Application getApplication(String appName) {
        return null;
    }

    @Override
    public Applications getApplications() {
        return null;
    }

    @Override
    public List<InstanceInfo> getInstancesById(String id) {
        return null;
    }

    @Override
    public InstanceInfo getNextServerFromEureka(String virtualHostname, boolean secure) {
        return null;
    }
}
