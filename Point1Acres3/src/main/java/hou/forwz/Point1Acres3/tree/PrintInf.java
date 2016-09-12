package hou.forwz.Point1Acres3.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年9月8日上午1:37:00
 * @end 2016年09月08日02:00:36
 */

public class PrintInf {
	public static void main(String[] args) {
		String str = "Fred,Karl,Technician,2010--Karl,Cathy,VP,2009--Cathy,NULL,CEO,2007";
		new PrintInf().print(str);
	}

	private void print(String str) {
		String[] people = str.split("--");

		Map<String, Person> map = new HashMap<>();
		Person boss = null;
		for (String cur : people) {
			String[] info = cur.split(",");
			Person p = new Person(info[0], info[1], info[2], info[3]);
			if (p.up.equals("NULL"))
				boss = p;
			map.put(p.name, p);
		}

		System.out.println(map.size());
		for (Map.Entry<String, Person> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}

		System.out.println("------");

		for (Map.Entry<String, Person> entry : map.entrySet()) {
			String up = entry.getValue().up;

			if (!up.equals("NULL")) {
				Person high = map.get(up);
				high.down.add(entry.getValue());
			}

		}

		dfs(boss, "");
	}

	private void dfs(Person boss, String pre) {
		if (boss == null)
			return;

		System.out.println(pre + boss);
		for (Person p : boss.down) {
			dfs(p, pre + "-");
		}
	}

	class Person {
		String name;
		String up;
		String workName;
		String year;
		List<Person> down;

		public Person(String name, String up, String workName, String year) {
			super();
			this.name = name;
			this.workName = workName;
			this.year = year;
			this.up = up;
			down = new ArrayList<>();
		}

		@Override
		public String toString() {
			return name + "(" + workName + ")" + year;
		}
	}
}
