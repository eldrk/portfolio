import org.springframework.beans.factory.annotation.Autowired;



import org.junit.Test;

public class BaseServiceTest<S> extends BaseTest {

	@Autowired
	S service;
	
	@Test
	public void test() {
		assert service != null:
			service.getClass().getSimpleName() + "바인딩 실패";
	}
}
