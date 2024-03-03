class Rev{
    Boolean Checker(String name){
        int start = 0;
        int end = name.length()-1;

        while (start < end) {
            if(name.charAt(start) != name.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }

        return true;
    }

    Boolean IntChecker(int x){
        int rev=0;
        int min = x;

        while (min != 0) {
            int id = min % 10;
            rev = rev*10+id;

            min = min / 10;
        }
        return rev == x;

    }

    public static void main(String[] args){
        Rev r = new Rev();

        Boolean c = r.Checker("madam");
        System.out.println(c);
    }
}