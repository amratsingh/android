
	//Need READ_PHONE_STATE Permission

	TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);  
         
        //Calling the methods of TelephonyManager the returns the information  
        String IMEINumber=tm.getDeviceId();  
        String subscriberID=tm.getDeviceId();  
        String SIMSerialNumber=tm.getSimSerialNumber();  
        String networkCountryISO=tm.getNetworkCountryIso();  
        String SIMCountryISO=tm.getSimCountryIso();  
        String softwareVersion=tm.getDeviceSoftwareVersion();  
        String voiceMailNumber=tm.getVoiceMailNumber();
          
        //getting information if phone is in roaming
        boolean isRoaming=tm.isNetworkRoaming();
          
        int phoneType=tm.getPhoneType();
          
        //Get the phone type
        String strphoneType="";
  
        switch (phoneType)
        {
                case (TelephonyManager.PHONE_TYPE_CDMA):
                           strphoneType="CDMA";
                               break;
                case (TelephonyManager.PHONE_TYPE_GSM):
                           strphoneType="GSM";
                               break;
                case (TelephonyManager.PHONE_TYPE_NONE):
                            strphoneType="NONE";
                                break;
         }
