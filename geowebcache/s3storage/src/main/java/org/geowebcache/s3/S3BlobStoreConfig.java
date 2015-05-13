/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Gabriel Roldan, Boundless Spatial Inc, Copyright 2015
 */
package org.geowebcache.s3;

import static com.google.common.base.Preconditions.checkState;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.geowebcache.config.BlobStoreConfig;
import org.geowebcache.storage.BlobStore;
import org.geowebcache.storage.StorageException;

/**
 * Plain old java object representing the configuration for an S3 blob store.
 */
public class S3BlobStoreConfig extends BlobStoreConfig {

    private String bucket;

    private String prefix;

    private String awsAccessKey;

    private String awsSecretKey;

    private int maxConnections;

    private boolean useHTTPS = true;

    private String proxyDomain;

    private String proxyWorkstation;

    private String proxyHost;

    private int proxyPort;

    private String proxyUsername;

    private String proxyPassword;

    private boolean useGzip;

    /**
     * @return the name of the AWS S3 bucket where to store tiles
     */
    public String getBucket() {
        return bucket;
    }

    /**
     * Sets the name of the AWS S3 bucket where to store tiles
     */
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    /**
     * Returns the base prefix, which is a prefix path to use as the root to store tiles under the
     * bucket.
     * 
     * @return optional string for a "base prefix"
     */
    @Nullable
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAwsAccessKey() {
        return awsAccessKey;
    }

    public void setAwsAccessKey(String awsAccessKey) {
        this.awsAccessKey = awsAccessKey;
    }

    public String getAwsSecretKey() {
        return awsSecretKey;
    }

    public void setAwsSecretKey(String awsSecretKey) {
        this.awsSecretKey = awsSecretKey;
    }

    /**
     * @return The maximum number of allowed open HTTP connections.
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * Sets the maximum number of allowed open HTTP connections.
     */
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * @return whether to use HTTPS (true) or HTTP (false) when talking to S3 (defaults to true)
     */
    public boolean isUseHTTPS() {
        return useHTTPS;
    }

    /**
     * @param useHTTPS whether to use HTTPS (true) or HTTP (false) when talking to S3
     */
    public void setUseHTTPS(boolean useHTTPS) {
        this.useHTTPS = useHTTPS;
    }

    /**
     * Returns the optional Windows domain name for configuring an NTLM proxy.
     * <p>
     * If you aren't using a Windows NTLM proxy, you do not need to set this field.
     *
     * @return The optional Windows domain name for configuring an NTLM proxy.
     */
    @Nullable
    public String getProxyDomain() {
        return proxyDomain;
    }

    /**
     * Sets the optional Windows domain name for configuration an NTLM proxy.
     * <p>
     * If you aren't using a Windows NTLM proxy, you do not need to set this field.
     *
     * @param proxyDomain The optional Windows domain name for configuring an NTLM proxy.
     */
    public void setProxyDomain(String proxyDomain) {
        this.proxyDomain = proxyDomain;
    }

    /**
     * Returns the optional Windows workstation name for configuring NTLM proxy support. If you
     * aren't using a Windows NTLM proxy, you do not need to set this field.
     *
     * @return The optional Windows workstation name for configuring NTLM proxy support.
     */
    @Nullable
    public String getProxyWorkstation() {
        return proxyWorkstation;
    }

    /**
     * Sets the optional Windows workstation name for configuring NTLM proxy support. If you aren't
     * using a Windows NTLM proxy, you do not need to set this field.
     *
     * @param proxyWorkstation The optional Windows workstation name for configuring NTLM proxy
     *        support.
     */
    public void setProxyWorkstation(String proxyWorkstation) {
        this.proxyWorkstation = proxyWorkstation;
    }

    /**
     * Returns the optional proxy host the client will connect through.
     *
     * @return The proxy host the client will connect through.
     */
    @Nullable
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * Sets the optional proxy host the client will connect through.
     *
     * @param proxyHost The proxy host the client will connect through.
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    /**
     * Returns the optional proxy port the client will connect through.
     *
     * @return The proxy port the client will connect through.
     */
    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * Sets the optional proxy port the client will connect through.
     *
     * @param proxyPort The proxy port the client will connect through.
     */
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    /**
     * Returns the optional proxy user name to use if connecting through a proxy.
     *
     * @return The optional proxy user name the configured client will use if connecting through a
     *         proxy.
     */
    @Nullable
    public String getProxyUsername() {
        return proxyUsername;
    }

    /**
     * Sets the optional proxy user name to use if connecting through a proxy.
     *
     * @param proxyUsername The proxy user name to use if connecting through a proxy.
     */
    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    /**
     * Returns the optional proxy password to use when connecting through a proxy.
     *
     * @return The password to use when connecting through a proxy.
     */
    @Nullable
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * Sets the optional proxy password to use when connecting through a proxy.
     *
     * @param proxyPassword The password to use when connecting through a proxy.
     */
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    /**
     * Checks if gzip compression is used
     *
     * @return if gzip compression is used
     */
    public boolean isUseGzip() {
        return useGzip;
    }

    /**
     * Sets whether gzip compression should be used
     *
     * @param use whether gzip compression should be used
     */
    public void setUseGzip(boolean use) {
        this.useGzip = use;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public BlobStore createInstance() throws StorageException {
        checkState(getId() != null);
        checkState(isEnabled(),
                "Can't call S3BlobStoreConfig.createInstance() is blob store is not enabled");
        return new S3BlobStore(this);
    }

}
