package order8082.demo.test;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TestImpl implements TestDefault {
    public TestImpl() {
        System.out.println("\n+tesone\n");

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
