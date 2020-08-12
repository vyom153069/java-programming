package university.management.system;


public class SplashScreen {
    public static void main(String[] args){
        Splash sp = new Splash();
        sp.setVisible(true);
        try{
            
            for(int i =0; i<= 100;i++){
                Thread.sleep(30);
                sp.jLabel2.setText(""+i);
                sp.jProgressBar1.setValue(i);
                if(i==100){
                    sp.setVisible(false);
                    new Login();
                }
           }
        }catch(Exception e){
        }
    }
    
}
