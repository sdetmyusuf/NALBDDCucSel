package fwutilities;

import java.util.Properties;

import constants.Environments;



public class ConfigurationLoader {
	
	private final Properties properties;
    private static ConfigurationLoader configLoader;

    private ConfigurationLoader(){
        String env = System.getProperty("env", String.valueOf(Environments.STAGE));
        switch (Environments.valueOf(env)){
            case PROD:
            	 properties = PropertyFileReaderUtil.propertyLoader("src/test/resources/prod_config.properties");
            	 break;
            case STAGE:
            	properties = PropertyFileReaderUtil.propertyLoader("src/test/resources/stage_config.properties");
            	break;
            default:
            	throw new IllegalStateException("INVALID ENV: " + env);
        }
    }

    public static ConfigurationLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigurationLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }

}
