package com.facebook.stetho.inspector.protocol.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@TargetApi(11)
public class Database
  implements ChromeDevtoolsDomain
{
  private static final int MAX_BLOB_LENGTH = 512;
  private static final int MAX_EXECUTE_RESULTS = 250;
  private static final String UNKNOWN_BLOB_LABEL = "{blob}";
  private final ChromePeerManager mChromePeerManager = new ChromePeerManager();
  private List<DatabaseDriver> mDatabaseDrivers = new ArrayList();
  private final ObjectMapper mObjectMapper;
  private final DatabasePeerRegistrationListener mPeerListener = new DatabasePeerRegistrationListener(this.mDatabaseDrivers, null);
  
  public Database()
  {
    this.mChromePeerManager.setListener(this.mPeerListener);
    this.mObjectMapper = new ObjectMapper();
  }
  
  private static String blobToString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length <= 512) && (fastIsAscii(paramArrayOfByte))) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "US-ASCII");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte) {}
    }
    return "{blob}";
  }
  
  private static boolean fastIsAscii(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      boolean bool1;
      if (i >= j) {
        bool1 = true;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while ((paramArrayOfByte[i] & 0xFFFFFF80) != 0);
      i += 1;
    }
  }
  
  private static ArrayList<String> flattenRows(Cursor paramCursor, int paramInt)
  {
    boolean bool;
    ArrayList localArrayList;
    int k;
    int i;
    if (paramInt >= 0)
    {
      bool = true;
      Util.throwIfNot(bool);
      localArrayList = new ArrayList();
      k = paramCursor.getColumnCount();
      i = 0;
      label30:
      if ((i < paramInt) && (paramCursor.moveToNext())) {
        break label69;
      }
      if (!paramCursor.isAfterLast()) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (paramInt >= k)
      {
        return localArrayList;
        bool = false;
        break;
        label69:
        int j = 0;
        if (j >= k)
        {
          i += 1;
          break label30;
        }
        switch (paramCursor.getType(j))
        {
        case 3: 
        default: 
          localArrayList.add(paramCursor.getString(j));
        }
        for (;;)
        {
          j += 1;
          break;
          localArrayList.add(null);
          continue;
          localArrayList.add(String.valueOf(paramCursor.getLong(j)));
          continue;
          localArrayList.add(String.valueOf(paramCursor.getDouble(j)));
          continue;
          localArrayList.add(blobToString(paramCursor.getBlob(j)));
        }
      }
      localArrayList.add("{truncated}");
      paramInt += 1;
    }
  }
  
  private DatabaseDriver getDatabasePeer(String paramString)
  {
    Iterator localIterator = this.mDatabaseDrivers.iterator();
    DatabaseDriver localDatabaseDriver;
    List localList;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localDatabaseDriver = (DatabaseDriver)localIterator.next();
      localList = localDatabaseDriver.getDatabaseNames();
    } while ((localList == null) || (!localList.contains(paramString)));
    return localDatabaseDriver;
  }
  
  public void add(DatabaseDriver paramDatabaseDriver)
  {
    this.mDatabaseDrivers.add(paramDatabaseDriver);
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mChromePeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mChromePeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult executeSQL(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (ExecuteSQLRequest)this.mObjectMapper.convertValue(paramJSONObject, ExecuteSQLRequest.class);
    paramJSONObject = paramJsonRpcPeer.databaseId;
    String str = paramJsonRpcPeer.query;
    paramJSONObject = getDatabasePeer(paramJSONObject);
    try
    {
      paramJsonRpcPeer = paramJSONObject.executeSQL(paramJsonRpcPeer.databaseId, paramJsonRpcPeer.query, new Database.DatabaseDriver.ExecuteResultHandler()
      {
        public Database.ExecuteSQLResponse handleInsert(long paramAnonymousLong)
          throws SQLiteException
        {
          Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
          localExecuteSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
          localExecuteSQLResponse.values = Collections.singletonList(String.valueOf(paramAnonymousLong));
          return localExecuteSQLResponse;
        }
        
        public Database.ExecuteSQLResponse handleRawQuery()
          throws SQLiteException
        {
          Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
          localExecuteSQLResponse.columnNames = Collections.singletonList("success");
          localExecuteSQLResponse.values = Collections.singletonList("true");
          return localExecuteSQLResponse;
        }
        
        public Database.ExecuteSQLResponse handleSelect(Cursor paramAnonymousCursor)
          throws SQLiteException
        {
          Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
          localExecuteSQLResponse.columnNames = Arrays.asList(paramAnonymousCursor.getColumnNames());
          localExecuteSQLResponse.values = Database.flattenRows(paramAnonymousCursor, 250);
          return localExecuteSQLResponse;
        }
        
        public Database.ExecuteSQLResponse handleUpdateDelete(int paramAnonymousInt)
          throws SQLiteException
        {
          Database.ExecuteSQLResponse localExecuteSQLResponse = new Database.ExecuteSQLResponse();
          localExecuteSQLResponse.columnNames = Collections.singletonList("Modified rows");
          localExecuteSQLResponse.values = Collections.singletonList(String.valueOf(paramAnonymousInt));
          return localExecuteSQLResponse;
        }
      });
      return paramJsonRpcPeer;
    }
    catch (SQLiteException paramJSONObject)
    {
      paramJsonRpcPeer = new Error();
      paramJsonRpcPeer.code = 0;
      paramJsonRpcPeer.message = paramJSONObject.getMessage();
      paramJSONObject = new ExecuteSQLResponse();
      paramJSONObject.sqlError = paramJsonRpcPeer;
    }
    return paramJSONObject;
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getDatabaseTableNames(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws JsonRpcException
  {
    paramJsonRpcPeer = (GetDatabaseTableNamesRequest)this.mObjectMapper.convertValue(paramJSONObject, GetDatabaseTableNamesRequest.class);
    paramJSONObject = getDatabasePeer(paramJsonRpcPeer.databaseId);
    try
    {
      GetDatabaseTableNamesResponse localGetDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse(null);
      localGetDatabaseTableNamesResponse.tableNames = paramJSONObject.getTableNames(paramJsonRpcPeer.databaseId);
      return localGetDatabaseTableNamesResponse;
    }
    catch (SQLiteException paramJsonRpcPeer)
    {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INVALID_REQUEST, paramJsonRpcPeer.toString(), null));
    }
  }
  
  public static class AddDatabaseEvent
  {
    @JsonProperty(required=true)
    public Database.DatabaseObject database;
  }
  
  public static abstract class DatabaseDriver
  {
    protected Context mContext;
    
    public DatabaseDriver(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private final void onRegistered(JsonRpcPeer paramJsonRpcPeer)
    {
      Iterator localIterator = getDatabaseNames().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        Object localObject = (String)localIterator.next();
        Database.DatabaseObject localDatabaseObject = new Database.DatabaseObject();
        localDatabaseObject.id = ((String)localObject);
        localDatabaseObject.name = ((String)localObject);
        localDatabaseObject.domain = this.mContext.getPackageName();
        localDatabaseObject.version = "N/A";
        localObject = new Database.AddDatabaseEvent();
        ((Database.AddDatabaseEvent)localObject).database = localDatabaseObject;
        paramJsonRpcPeer.invokeMethod("Database.addDatabase", localObject, null);
      }
    }
    
    private final void onUnregistered(JsonRpcPeer paramJsonRpcPeer) {}
    
    public abstract Database.ExecuteSQLResponse executeSQL(String paramString1, String paramString2, ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler)
      throws SQLiteException;
    
    public abstract List<String> getDatabaseNames();
    
    public abstract List<String> getTableNames(String paramString);
    
    public static abstract interface ExecuteResultHandler<T>
    {
      public abstract T handleInsert(long paramLong)
        throws SQLiteException;
      
      public abstract T handleRawQuery()
        throws SQLiteException;
      
      public abstract T handleSelect(Cursor paramCursor)
        throws SQLiteException;
      
      public abstract T handleUpdateDelete(int paramInt)
        throws SQLiteException;
    }
  }
  
  public static class DatabaseObject
  {
    @JsonProperty(required=true)
    public String domain;
    @JsonProperty(required=true)
    public String id;
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public String version;
  }
  
  private static class DatabasePeerRegistrationListener
    implements PeerRegistrationListener
  {
    private final List<Database.DatabaseDriver> mDatabaseDrivers;
    
    private DatabasePeerRegistrationListener(List<Database.DatabaseDriver> paramList)
    {
      this.mDatabaseDrivers = paramList;
    }
    
    public void onPeerRegistered(JsonRpcPeer paramJsonRpcPeer)
    {
      Iterator localIterator = this.mDatabaseDrivers.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((Database.DatabaseDriver)localIterator.next()).onRegistered(paramJsonRpcPeer);
      }
    }
    
    public void onPeerUnregistered(JsonRpcPeer paramJsonRpcPeer)
    {
      Iterator localIterator = this.mDatabaseDrivers.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((Database.DatabaseDriver)localIterator.next()).onUnregistered(paramJsonRpcPeer);
      }
    }
  }
  
  public static class Error
  {
    @JsonProperty(required=true)
    public int code;
    @JsonProperty(required=true)
    public String message;
  }
  
  public static class ExecuteSQLRequest
  {
    @JsonProperty(required=true)
    public String databaseId;
    @JsonProperty(required=true)
    public String query;
  }
  
  public static class ExecuteSQLResponse
    implements JsonRpcResult
  {
    @JsonProperty
    public List<String> columnNames;
    @JsonProperty
    public Database.Error sqlError;
    @JsonProperty
    public List<String> values;
  }
  
  private static class GetDatabaseTableNamesRequest
  {
    @JsonProperty(required=true)
    public String databaseId;
  }
  
  private static class GetDatabaseTableNamesResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<String> tableNames;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\Database.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */