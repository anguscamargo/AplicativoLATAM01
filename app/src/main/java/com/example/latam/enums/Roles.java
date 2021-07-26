package com.example.latam.enums;

public enum Roles {
    SALESMAN(1), VET(2), MANAGER(3), SUPPLIER(4), DIRECTOR(5), PRESIDENT(6), INVESTOR(7);

    public int value;

    Roles(int value){
        this.value = value;
    }

    public static String stringfy(int index){
        switch(index){
            case 1:
                return "Atendente";

            case 2:
                return "Veterinário";

            case 3:
                return "Gerente";

            case 4:
                return "Estoquista";

            case 5:
                return "Diretor";

            case 6:
                return "Presidente";
        }
        return  null;
    }
}
