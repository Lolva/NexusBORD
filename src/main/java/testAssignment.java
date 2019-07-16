import java.util.List;

import com.atossyntel.springboot.controller.*;

public class testAssignment {

	public static void main(String[] args) {
		AssignmentDAO dao = new AssignmentDAOService();
		List<AssignmentBean> bean = dao.getAssignment("DG5061505");
		
			for(AssignmentBean r: bean) {
				System.out.println(r.toString());
			}
		
		
	}

}
