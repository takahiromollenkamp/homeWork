import java.util.Scanner;

class Player {
	private int location=0;
	public void moveLocation(int amount){
		this.location+=amount;
	}	
	public int getLocation(){
		return location;
	}
	public void movePlayer(int num){
		if(num==4||num==6){
			this.location-=num;
		}
		else this.location+=num;
		if(this.location<0){
			this.location=0;
		}
	}
	public void penalty(){
		this.location=0;
	}
	public static void main(String args[]){
		Player a=new Player();
		Player b=new Player();
		System.out.println("Yo enter a line");
		Scanner input=new Scanner (System.in);
		String line=input.nextLine();
		while(line.equals("quit")==false){
		String[] bsMoveNums=line.split(",");
		int [] moveNums=new int[bsMoveNums.length];
		for(int i=0; i<moveNums.length; i++){
			moveNums[i]=Integer.parseInt(bsMoveNums[i]);
		}
		
		int move=moveNums[0];
		for(int i=0; move!=0; i++){ 
			if(i%2==0){
				a.movePlayer(move);
				if (a.getLocation()==b.getLocation()){
					b.penalty();
				}
				
			}
			if(i%2==1){
				b.movePlayer(move);
				
				if (a.getLocation()==b.getLocation()){
					a.penalty();
				}
			}
			move=moveNums[i+1];
            if(a.getLocation()>=39||b.getLocation()>=39){
            	move=0;
            }
		}
		String aAns;
		String bAns;
		if(a.getLocation()>=39){
			aAns="END";
		} else { aAns=""+a.getLocation();}
		if(b.getLocation()>=39){
			bAns="END";
		} else{bAns=""+b.getLocation();}
				
        System.out.println("A-"+aAns+", B-"+bAns);
        System.out.println("another line");
        a.penalty();
        b.penalty();
        line=input.nextLine();
		}
      
	}
}
