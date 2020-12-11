package order8082.demo.test;

import com.google.inject.ImplementedBy;
import com.netflix.discovery.shared.LookupService;

@ImplementedBy(TestImpl.class)
public interface TestDefault extends LookupService {
}
