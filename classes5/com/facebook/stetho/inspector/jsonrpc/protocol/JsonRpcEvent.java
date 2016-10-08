package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import javax.annotation.Nullable;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcEvent
{
  @JsonProperty(required=true)
  public String method;
  @JsonProperty
  public JSONObject params;
  
  public JsonRpcEvent() {}
  
  public JsonRpcEvent(String paramString, @Nullable JSONObject paramJSONObject)
  {
    this.method = paramString;
    this.params = paramJSONObject;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\jsonrpc\protocol\JsonRpcEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */