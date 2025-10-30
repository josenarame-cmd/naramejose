
public class SoilAnalysis_24rp08520 {


    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;



    public SoilAnalysis_24rp08520(String farmerId, String districtName, double nitrogenLevel,
                        double phosphorusLevel, double potassiumLevel, String cropType) {
        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getCropType() {
        return cropType;
    }

    public String calculateFertilizerNeeded() {

        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }


        if (nitrogenLevel < 20 || phosphorusLevel < 20 || potassiumLevel < 20) {
            String deficientNutrients = "";
            if (nitrogenLevel < 20) deficientNutrients += "Nitrogen ";
            if (phosphorusLevel < 20) deficientNutrients += "Phosphorus ";
            if (potassiumLevel < 20) deficientNutrients += "Potassium ";
            return "DEFICIENT - High application needed for " + deficientNutrients.trim();
        }

        if (nitrogenLevel > 100 || phosphorusLevel > 100 || potassiumLevel > 100) {
            String excessNutrients = "";
            if (nitrogenLevel > 100) excessNutrients += "Nitrogen ";
            if (phosphorusLevel > 100) excessNutrients += "Phosphorus ";
            if (potassiumLevel > 100) excessNutrients += "Potassium ";
            return "EXCESS - Reduce " + excessNutrients.trim() + " application";
        }


        return "OPTIMAL - Maintenance fertilizer only";
    }

    public void displayReport() {

        System.out.println("Farmer ID: " + farmerId);
        System.out.println("District: " + districtName);
        System.out.println("Crop Type: " + cropType);
        // Using String.format to ensure consistent decimal formatting (e.g., 45.0)
        System.out.println(String.format("N: %.1f ppm | P: %.1f ppm | K: %.1f ppm",
                nitrogenLevel, phosphorusLevel, potassiumLevel));
        System.out.println("Fertilizer Recommendation: " + calculateFertilizerNeeded());
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("SOIL ANALYSIS REPORT");
        System.out.println("=======================================================");

        try {

            SoilAnalysis_24rp08520 s1 = new SoilAnalysis_24rp08520("F001", "Kirehe", 50, 70, 80, "Maize");


            SoilAnalysis_24rp08520 s2 = new SoilAnalysis_24rp08520("F002", "Bugesera", 10, 45, 60, "Rice");


            SoilAnalysis_24rp08520 s3 = new SoilAnalysis_24rp08520("F003", "Nyagatare", 110, 90, 85, "Beans");


            SoilAnalysis_24rp08520 s4 = new SoilAnalysis_24rp08520("F004", "Gatsibo", -5, 40, 60, "Maize");
            SoilAnalysis_24rp08520 s5 = new SoilAnalysis_24rp08520("F005", "Huye", 15, 15, 18, "Rice");


            s1.displayReport();
            s2.displayReport();
            s3.displayReport();
            s5.displayReport();


            s4.displayReport();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("=======================================================");
        }
    }
}
