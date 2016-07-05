package book.acl;
import java.security.NoSuchAlgorithmException;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

//对“username:password”进行编码
public class DigestAuthenticationProviderUsage {
	public static void main( String[] args ) throws NoSuchAlgorithmException {
		System.out.println( DigestAuthenticationProvider.generateDigest( "super:zk-book" ) );
	}
}