package server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;


public class FileCacheManager<Problem,Solution> implements CacheManager<Problem,Solution>  {

	HashMap<Problem,Solution> problemSolutionHashMap;
	Properties myProperties;
	
	@SuppressWarnings("unchecked")
	public FileCacheManager() {
		myProperties=new Properties();
		String name="cache.properties";
		try {
			myProperties.load(new FileInputStream(name));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.problemSolutionHashMap =new HashMap<>();
		if(myProperties!=null)
		{
			
			Enumeration<?> E=myProperties.propertyNames();
			while(E.hasMoreElements())
			{
				Problem key=(Problem)E.nextElement();
				if(key!=null)
					this.problemSolutionHashMap.put(key,(Solution) myProperties.get(key));
			}
		}
		
	}

	@Override
	public Boolean check(Problem in) {
		if(problemSolutionHashMap.isEmpty())
			return false;
		return problemSolutionHashMap.containsKey(in);
		
	}

	@Override
	public Solution extract(Problem in) {
		return problemSolutionHashMap.get(in);
	}

	@Override
	public void save(Problem in, Solution out) {
		problemSolutionHashMap.put(in, out);
		myProperties.putAll(this.problemSolutionHashMap);
		String name="cache.properties";
		try {
			myProperties.store(new FileOutputStream(name), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
