package org.demo.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.demo.app.domain.Client;
import org.demo.app.domain.Color;
import org.demo.app.domain.Shape;

public class App {
	   
	public static void main(String[] args) {

		try (SqlSession session = MyBatisUtil.openSession()) {
			System.out.println("SqlSession open.");

			Shape shape = session.selectOne("Shape.findOne", 2) ;
			System.out.println("findOne : Shape : " + shape );
			//Shape shape2 = new Shape(1001, "red");
			Shape shape2 = new Shape(1024, Color.red);
			int r = session.insert("Shape.insert", shape2);
			System.out.println("insert : r = " + r );
			session.commit();
			
			List<Client> clients = session.selectList("Client.findAll") ;
			System.out.println("findAll : " + clients.size() + " record(s) found.");
			for ( Client c : clients ) {
				System.out.println(" . " + c );
			}
			
			Client c = session.selectOne("Client.findOne", 2) ;
			if ( c != null ) {
				System.out.println("findOne : FOUND : " + c );
				c.setFirstName(c.getFirstName()+"(UPDATED)");
				r = session.update("Client.update", c);
				System.out.println("update : r = " + r );
				r = session.delete("Client.delete", c);
				System.out.println("delete : r = " + r );
				r = session.delete("Client.deleteByPK", 2);
				System.out.println("deleteByPK : r = " + r );
				// No commit (to reuse several times)
			}
			else {
				System.out.println("findOne : NOT FOUND " );
			}
			

			Map<String,Object> params = new HashMap<>();
			params.put("ageMin", Integer.valueOf(30));
			params.put("ageMax", Integer.valueOf(40));
			clients = session.selectList("Client.findByAge", params) ;
			System.out.println("findByAge : " + clients.size() + " record(s) found.");
			for ( Client client : clients ) {
				System.out.println(" . " + client );
			}
		}
	}

}
