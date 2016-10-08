package com.rookery.translate.microsoft;

import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.Translator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gcj;
import gck;
import gcl;
import gcm;
import gcn;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class MicrosoftTranslator
  extends Translator
{
  private static MicrosoftTranslator jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator;
  private gcn jdField_a_of_type_Gcn;
  public DocumentBuilder a;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory;
  
  private MicrosoftTranslator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Gcn = new gcn(this, null);
    this.jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      this.jdField_a_of_type_JavaxXmlParsersDocumentBuilder = this.jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory.newDocumentBuilder();
      return;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
    }
  }
  
  public static MicrosoftTranslator a()
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator == null) {
        jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator = new MicrosoftTranslator();
      }
      return jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftTranslator;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, JsonHttpResponseHandler paramJsonHttpResponseHandler)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "http://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      gcj.a(paramContext, null, paramLong, new gcm(this, paramJsonHttpResponseHandler));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramJsonHttpResponseHandler.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List paramList, Language paramLanguage, String paramString, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new gcl(this, paramList, paramTranslateWithTimeCallback, paramLong);
        gcj.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (AsyncHttpResponseHandler)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramTranslateWithTimeCallback.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramTranslateWithTimeCallback.a(new TranslateError(paramContext), paramLong);
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
      }
    }
  }
  
  public void a(Context paramContext, List paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Gcn.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Gcn.jdField_a_of_type_JavaLangString, paramLong, paramTranslateWithTimeCallback);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new gck(this, paramLong, paramContext, paramList, paramLanguage, paramTranslateWithTimeCallback));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\microsoft\MicrosoftTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */