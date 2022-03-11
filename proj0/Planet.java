public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double xdistance = p.xxPos - xxPos;
        double ydistance = p.yyPos - yyPos;
        double r = Math.sqrt(xdistance*xdistance + ydistance * ydistance);
        return r;
    }

    public double calcForceExertedBy(Planet p){
        double G = 6.67e-11;
        double r = calcDistance(p);
        double force = G * mass * p.mass /(r * r);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double forceX = calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
        return forceX;
    }
    public double calcForceExertedByY(Planet p){
        double forceY = calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
        return forceY;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netForceX = 0;
        for(Planet p : allPlanets){
            if(this.equals(p)){
                continue;
            }
            netForceX += calcForceExertedByX(p);
        }
        return netForceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netForceY = 0;
        for(Planet p : allPlanets){
            if(this.equals(p)){
                continue;
            }
            netForceY += calcForceExertedByY(p);
        }
        return netForceY;
    }
    public void update(double dt, double fX, double fY){
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + aX * dt;
        yyVel = yyVel + aY * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }
    public void draw(){
        String file = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, file);
    }
}