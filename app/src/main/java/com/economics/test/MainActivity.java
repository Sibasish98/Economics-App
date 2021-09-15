package com.economics.test;

import android.view.View;
import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity
{
    double ed,es;
    String dslope="",sslope="";
    int constantResult,variableResult,resultt,eq,pcp,pfp;
    String left,right,demand,supply,dconstant,dvariable,svariable,sconstant,out=null;
    String ceil="",floor="";
    String result="";
    int selected=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText prod=(EditText)findViewById(R.id.prod);
        prod.setVisibility(View.GONE);

// Gets a reference to our "selected" radio button


// Now you can get the text or whatever you want from the "selected" radio button

    }
    public void buttonClicked(View v){
        //TextView tvv=(TextView)findViewById(R.id.tvi);
        EditText qd=(EditText)findViewById(R.id.qd);
        EditText qs=(EditText)findViewById(R.id.qs);
        EditText pc=(EditText)findViewById(R.id.pc);
        EditText pf=(EditText)findViewById(R.id.pf);
        EditText ta=(EditText)findViewById(R.id.ta);

        qd.setVisibility(View.GONE);
        qs.setVisibility(View.GONE);
        pc.setVisibility(View.GONE);
        pf.setVisibility(View.GONE);
        ta.setVisibility(View.GONE);
        demand=qd.getText().toString();
        supply=qs.getText().toString();
        ceil=pc.getText().toString();
        floor=pf.getText().toString();



        //Toast.makeText(this,""+obj.finalResult(),Toast.LENGTH_SHORT).show();
        result=result+"Quantity demanded (Qd) = "+qd.getText().toString();
        result=result+"\n"+"Quantity supplied (Qs) = "+qs.getText().toString();
        result=result+"\n"+"At equilibrium price : - "+"\n"+"Qd=Qs"+"\n"+qd.getText().toString()+" = "+qs.getText().toString();
        start();
        result=result+"\n"+"At equilibrium price ₹ "+resultt+" Qd = Qs "+"\n";
        qe();
        ceilTest();
        floorTest();
        calcDemand();
        calcSupply();
        checkElasticity();
        taxOnBuyer(ta.getText().toString());
        setContentView(R.layout.result);
        TextView t=(TextView)findViewById(R.id.tvv);
        t.setText(result);
        //tvv.setText(result);
    }
    public void taxOnBuyer(String amount){
        result=result+"\n"+"Tax burden on buyer = es/(ed+es)";
        result=result+"\n"+"= > "+es+"/"+"("+es+"+"+ed+")";
        double bb=es/(es+ed);
        result=result+"\n"+"= > "+bb;
        result=result+"\n"+"Tax burden on seller = ed/(ed+es)";
        result=result+"\n"+"= > "+ed+"/"+"("+es+"+"+ed+")";
        double sb=ed/(es+ed);
        result=result+"\n"+"= > "+sb;
    }
    public void taxOnSeller(String amount){
        result=result+"\n"+"Tax burden on buyer = es/(ed+es)";
        result=result+"\n"+"= > "+es+"/"+"("+es+"+"+ed+")";
        double bb=es/(es+ed);
        result=result+"\n"+"= > "+bb;
        result=result+"\n"+"Tax burden on seller = ed/(ed+es)";
        result=result+"\n"+"= > "+ed+"/"+"("+es+"+"+ed+")";
        double sb=ed/(es+ed);
        result=result+"\n"+"= > "+sb;
    }
    public void checkElasticity(){

        if (ed>1)
            result=result+"\n"+"Demand elasticity is greater than 1 so, increasing price will not help in increase in revenue";
        else if (ed<1){
            result=result+"\n"+"Demand elasticity is less than 1 so it is relative inelastic so increasing price would increase revenur";
            ed=-ed;
            result=result+"\n"+"taking mod "+ed;}
        else
            result=result+"\n"+"Demand is unitary elastic";
    }
    public void calcDemand(){
        result=result+"/n";
        result=result+"Demand elasticty with respect to price = (dQ/dp)*P/Q .";
        int length=demand.length();
        for (int i=0;i<length;i++){
            if (demand.charAt(i)=='p'){
                for (int j=i;j>=0;j--){
                    if (demand.charAt(j)=='+'||demand.charAt(j)=='-'){
                        svariable=this.demand.substring(j,i);
                        sconstant=demand.substring(0,j);
                        break;
                    }
                }
            }
        }
        dslope=svariable;
        result=result+"\n";
        result=result+"dQd/dp = "+dslope;
        double edd=((double)resultt)/eq;
        result=result+"\n"+"p/Q = "+resultt+"/"+eq+" = "+edd;
        ed=Integer.parseInt(dslope)*edd;
        result=result+"\n"+"Demand elasticity = "+dslope+"*"+ed+" = "+ed;

    }
    public void calcSupply(){
        result=result+"/n";
        result=result+"Supply elasticty with respect to price = (dQs/dp)*P/Qs .";
        int length=supply.length();
        for (int i=0;i<length;i++){
            if (supply.charAt(i)=='p'){
                for (int j=i;j>=0;j--){
                    if (supply.charAt(j)=='+'||supply.charAt(j)=='-'){
                        svariable=this.supply.substring(j,i);
                        sconstant=supply.substring(0,j);
                        break;
                    }
                }
            }
        }
        sslope=svariable;
        result=result+"\n";
        result=result+"dQd/dp = "+sslope;
        double edd=((double)resultt)/eq;
        result=result+"\n"+"p/Q = "+resultt+"/"+eq+" = "+edd;
        es=Integer.parseInt(sslope)*edd;
        result=result+"\n"+"Supply elasticity = "+sslope+"*"+edd+" = "+es;

    }
    public void ceilTest(){
        result=result+"Price ceiling = ₹ "+ceil;
        if (Integer.parseInt(ceil)==resultt){
            result=result+"\n"+"It will have no difference because equilibrium price is same as price ceiling . ";
        }
        else if (Integer.parseInt(ceil)>resultt){
            result=result+"\n"+"The price is not binding because the price is set above equilibrium price. It will not protect interest of producer or seller.";
        }
        else{
            result=result+"\n"+"The price is binding and it will protect the interest of producer or seller.";
        }
    }
    public void floorTest(){
        result=result+"Price floor = ₹ "+floor;
        if (Integer.parseInt(floor)==resultt){
            result=result+"\n"+"It will have no difference because equilibrium price is same as price ceiling . ";
        }
        else if (Integer.parseInt(floor)>resultt){
            result=result+"The price is  binding because the price is set above equilibrium price. It will  protect interest of producer or seller.";
        }
        else{
            result=result+"The price is not binding and it will  not protect the interest of producer or seller.";
        }
    }
    public void qe(){
        int length=demand.length();
        int re;
        String tmp="",o1="";
        result=result+"\n";
        result=result+"Qd = "+demand;
        int ro;
        for (int i=1;i<length;i++){
            if (dvariable.charAt(i)=='p'){
                o1=dvariable.substring(1,i);
                break;
            }
        }
        ro=Integer.parseInt(o1)*resultt;
        if (dvariable.charAt(0)=='+'){
            re=Integer.parseInt(dconstant)+ro;
            result=result+" = > "+dconstant+"+"+ro;
        }
        else{
            re=Integer.parseInt(dconstant)-ro;
            result=result+"\n"+"Qd = "+demand;
            result=result+" = > "+dconstant+"-"+o1+"*"+resultt;}

        eq=re;
        result=result+"\n"+" = > Qd = "+re;
        result=result+"\n"+"Qd=Qs=Qe (At equilibrium)";
    }


    public  void start() {
        //MainActivity obj=new MainActivity();

        arrangeLeft();
        arrangeRight();
        result=result+"\n"+" = > "+this.left+" = "+this.right;
        result=result+"\n";
        solveLeft();
        solveRight();
        solveConstant();
        solveVariable();
        finalResult();

    }

    public void arrangeLeft(){
        left=demand;
    }
    public void arrangeRight(){
        if (supply.charAt(0)=='-'){
            right=supply;
        }
        else
        {
            right="+"+supply;
        }
    }
    public void solveLeft(){
        int length=left.length();
        for (int i=0;i<length;i++){
            if (demand.charAt(i)=='p'){
                for (int j=i;j>=0;j--){
                    if (left.charAt(j)=='+'||left.charAt(j)=='-'){
                        dvariable=left.substring(j,i+1);
                        dconstant=left.substring(0,j);
                        break;
                    }
                }
            }
        }

    }
    public void solveRight(){
        int length=right.length();
        for (int i=0;i<length;i++){
            if (right.charAt(i)=='p'){
                for (int j=i;j>=0;j--){
                    if (right.charAt(j)=='+'||right.charAt(j)=='-'){
                        svariable=this.right.substring(j,i+1);
                        sconstant=right.substring(0,j);
                        break;
                    }
                }
            }
        }

    }
    public void solveConstant(){
        int length=right.length();
        char s;
        if (right.charAt(0)=='+'){
            s='-';
        }
        else
        {
            s='+';
        }
        String temp=s+sconstant.substring(1);
        result=result+" = > "+dconstant+s+sconstant.substring(1);
        result=result+"\n";
        constantResult=Integer.parseInt(dconstant)+Integer.parseInt(temp);
    }
    public void solveVariable(){

        char s;
        String o1="",o2="";
        int length=dvariable.length();
        if (dvariable.charAt(0)=='+'){
            s='-';
        }
        else
        {
            s='+';
        }
        for (int i=1;i<length;i++){
            if (dvariable.charAt(i)=='p'){
                o1=dvariable.substring(1,i);
                break;
            }
        }
        length=svariable.length();
        for (int i=0;i<length;i++){
            if (svariable.charAt(i)=='p'){
                o2=svariable.substring(0,i);
                break;
            }
        }
        String tt=s+o1;
        if (svariable.charAt(0)=='-')
            result=result+" = "+"-"+svariable.substring(1)+s+dvariable.substring(1);
        else
            result=result+" = "+svariable+s+dvariable.substring(1);
        result=result+"\n";
        variableResult=Integer.parseInt(o2)+Integer.parseInt(tt);
    }
    public void finalResult(){
        resultt=constantResult/variableResult;
        result=result+" = > "+constantResult+ " = "+variableResult+"p";
        result=result+"\n";
        result=result+" = > "+"p = "+constantResult+"/"+variableResult;
        result=result+"\n";
        result=result+" = > p = "+resultt;

    }
}