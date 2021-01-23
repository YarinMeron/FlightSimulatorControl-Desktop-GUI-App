package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MyTestClientHandler<Problem,Solution> implements ClientHandler {

	@SuppressWarnings("rawtypes")
	private Solver solver;
	@SuppressWarnings("rawtypes")
	private CacheManager cm;
	
	public MyTestClientHandler(CacheManager cm ,Solver s) {
		this.solver=s;
		this.cm=cm;
	}

	
	@Override
	public void handleClient(InputStream in, OutputStream out)  {
		BufferedReader in=new BufferedReader(new InputStreamReader(in));
		PrintWriter out=new PrintWriter(new OutputStreamWriter(out));
		try {
			Problem Line;
			Solution Solved;
			
			while(!(Line=(Problem) in.readLine()).equals("end"))
			{
				
				if(cm.check(Line))
				{
					Solved=(Solution)cm.extract(Line);
				}
				else {
				//solver=String->new StringBuilder().reverse().toString();
				
				Solved=(Solution) solver.Solve(Line);
				cm.save(Line, Solved);
				}
				out.println(Solved);
				out.flush();

			}
			
		}catch (IOException e) {e.printStackTrace();}
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
