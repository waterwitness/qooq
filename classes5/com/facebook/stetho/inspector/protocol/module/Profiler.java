package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class Profiler
  implements ChromeDevtoolsDomain
{
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getProfileHeaders(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = new ProfileHeaderResponse(null);
    paramJsonRpcPeer.headers = Collections.emptyList();
    return paramJsonRpcPeer;
  }
  
  @ChromeDevtoolsMethod
  public void setSamplingInterval(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  private static class ProfileHeader
  {
    @JsonProperty(required=true)
    String title;
    @JsonProperty(required=true)
    String typeId;
    @JsonProperty(required=true)
    int uid;
  }
  
  private static class ProfileHeaderResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<Profiler.ProfileHeader> headers;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Profiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */