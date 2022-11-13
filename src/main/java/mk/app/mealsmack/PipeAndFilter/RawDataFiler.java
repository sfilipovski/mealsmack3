package mk.app.mealsmack.PipeAndFilter;

public class RawDataFiler implements Filter<String>{
    @Override
    public String execute(String input) {
        String []parts = input.split("\\,",-1);
        if(!(parts[1].equals("")) && !(parts[2].equals("")) && !(parts[4].equals("")) ){
            String s = "";
            for(int i = 0;i<7;i++){
                s+=parts[i]+",";
            }
            s+="\n";
            return s.substring(0,s.length()-1);
        }
        return "";







        /*StringBuilder stringBuilder = new StringBuilder();
        for(int i =0 ; i < parts.length; i++){
            if(parts[i].equals(" ") || parts[i].isEmpty()){
                return "";
            }
            stringBuilder.append(parts[i]+",");
        }
        return stringBuilder.toString().substring(0,stringBuilder.length()-1);*/

    }
}
