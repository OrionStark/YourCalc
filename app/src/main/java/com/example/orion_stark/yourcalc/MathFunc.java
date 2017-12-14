package com.example.orion_stark.yourcalc;

/**
 * Created by orion_stark on 02/11/17.
 * I have no idea wut I'm doing
 */
import java.util.*;

public class MathFunc {
    public int a, b, c, d;

    /**
     * Set value
     * @param a
     * @param b
     * @param c
     * @param d
     * @throws Exception
     */
    public void setValue(int a, int b, int c, int d) throws Exception {
        if( b == 0 || d == 0){
            throw new Exception("B and/or D can't be 0");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    /**
     * A = 0; B = 1;
     * @return List of integer
     * @throws Exception
     */
    public List<Integer> tambah() throws Exception {
        int tmp;
        List<Integer> result = new ArrayList<>();
        if(!(this.b == this.d)){
            tmp = this.b * this.d;
            /*
            result.add( (this.d * this.a) + (this.b * this.c) );
            result.add(tmp);
            */
            result = sederhanakan((this.d * this.a) + (this.b * this.c), tmp);
        } else {
            /*
            result.add(this.a + this.c);
            result.add(this.b);
            */
            result = sederhanakan(this.a + this.c, this.b);
        }
        System.out.println("Tambah " + result.get(0).toString() + " : " + result.get(1).toString());
        return result;
    }

    /**
     * A = 0; B = 1;
     * @return List of Integer
     */
    public List<Integer> kurang(){
        int tmp;
        List<Integer> result = new ArrayList<>();
        if(!(this.b == this.d)){
            tmp = this.b * this.d;
            /*
            result.add( (this.d * this.a) - (this.b * this.c) );
            result.add(tmp);
            */
            result = sederhanakan((this.d * this.a) - (this.b * this.c), tmp);
        } else {
            /*
            result.add(this.a - this.c);
            result.add(this.b);
            */
            result = sederhanakan(this.a - this.c, this.b);
        }
        System.out.println("Kurang " + result.get(0).toString() + " : " + result.get(1).toString());
        return result;
    }

    /**
     * A = 0; B = 1;
     * @return List of Integer
     */
    public List<Integer> kali() throws Exception {
        List<Integer> result = new ArrayList<>();
        if(this.b * this.d == 0){
            throw new Exception("Infinite results");
        } else {/*
            result.add(this.a * this.c);
            result.add(this.b * this.d);
            */
            result = sederhanakan(this.a * this.c, this.b * this.d);
        }
        System.out.println("Kali " + result.get(0).toString() + " : " + result.get(1).toString());
        return result;
    }

    /**
     * A = 0; B = 1;
     * @return List of Integer
     */
    public List<Integer> bagi() throws Exception {
        List<Integer> result = new ArrayList<>();
        if(this.b * this.c == 0){
            throw new Exception("Infinite results");
        } else {
            /*
            result.add(this.a * this.d);
            result.add(this.b * this.c);
            */
            result = sederhanakan(this.a * this.d, this.b * this.c);
        }
        System.out.println("Bagi " + result.get(0).toString() + " : " + result.get(1).toString());
        return result;
    }

    private int cariPembagi(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return cariPembagi(b, a % b);
        }
    }

    private List<Integer> sederhanakan(int a, int b) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(a / cariPembagi(a, b));
        tmp.add(b / cariPembagi(a, b));
        return tmp;
    }
}
