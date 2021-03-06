package org.apereo.cas.configuration.model.core.ticket.registry;

import org.apereo.cas.configuration.model.core.util.CryptographyProperties;
import org.apereo.cas.configuration.model.support.couchbase.ticketregistry.CouchbaseTicketRegistryProperties;
import org.apereo.cas.configuration.model.support.ehcache.EhcacheProperties;
import org.apereo.cas.configuration.model.support.hazelcast.HazelcastProperties;
import org.apereo.cas.configuration.model.support.ignite.IgniteProperties;
import org.apereo.cas.configuration.model.support.infinispan.InfinispanProperties;
import org.apereo.cas.configuration.model.support.jpa.ticketregistry.JpaTicketRegistryProperties;
import org.apereo.cas.configuration.model.support.memcached.MemcachedTicketRegistryProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * This is {@link TicketRegistryProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */

public class TicketRegistryProperties extends CryptographyProperties {

    @NestedConfigurationProperty
    private InfinispanProperties infinispan = new InfinispanProperties();
    
    @NestedConfigurationProperty
    private CouchbaseTicketRegistryProperties couchbase =
            new CouchbaseTicketRegistryProperties();
    
    @NestedConfigurationProperty
    private EhcacheProperties ehcache = new EhcacheProperties();

    @NestedConfigurationProperty
    private HazelcastProperties hazelcast = new HazelcastProperties();

    @NestedConfigurationProperty
    private IgniteProperties ignite = new IgniteProperties();

    @NestedConfigurationProperty
    private JpaTicketRegistryProperties jpa = new JpaTicketRegistryProperties();

    @NestedConfigurationProperty
    private MemcachedTicketRegistryProperties memcached = new MemcachedTicketRegistryProperties();
    
    private InMemory inMemory = new InMemory();
    private Cleaner cleaner = new Cleaner();

    public InMemory getInMemory() {
        return inMemory;
    }

    public void setInMemory(final InMemory inMemory) {
        this.inMemory = inMemory;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(final Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public CouchbaseTicketRegistryProperties getCouchbase() {
        return couchbase;
    }

    public void setCouchbase(final CouchbaseTicketRegistryProperties couchbase) {
        this.couchbase = couchbase;
    }

    public EhcacheProperties getEhcache() {
        return ehcache;
    }

    public void setEhcache(final EhcacheProperties ehcache) {
        this.ehcache = ehcache;
    }

    public HazelcastProperties getHazelcast() {
        return hazelcast;
    }

    public void setHazelcast(final HazelcastProperties hazelcast) {
        this.hazelcast = hazelcast;
    }

    public IgniteProperties getIgnite() {
        return ignite;
    }

    public void setIgnite(final IgniteProperties ignite) {
        this.ignite = ignite;
    }

    public JpaTicketRegistryProperties getJpa() {
        return jpa;
    }

    public void setJpa(final JpaTicketRegistryProperties jpa) {
        this.jpa = jpa;
    }

    public MemcachedTicketRegistryProperties getMemcached() {
        return memcached;
    }

    public void setMemcached(final MemcachedTicketRegistryProperties memcached) {
        this.memcached = memcached;
    }

    public InfinispanProperties getInfinispan() {
        return infinispan;
    }

    public void setInfinispan(final InfinispanProperties infinispan) {
        this.infinispan = infinispan;
    }

    public static class InMemory {
        private int initialCapacity = 1000;
        private int loadFactor = 1;
        private int concurrency = 20;

        public int getInitialCapacity() {
            return initialCapacity;
        }

        public void setInitialCapacity(final int initialCapacity) {
            this.initialCapacity = initialCapacity;
        }

        public int getLoadFactor() {
            return loadFactor;
        }

        public void setLoadFactor(final int loadFactor) {
            this.loadFactor = loadFactor;
        }

        public int getConcurrency() {
            return concurrency;
        }

        public void setConcurrency(final int concurrency) {
            this.concurrency = concurrency;
        }
    }
    
    public static class Cleaner {
        private boolean enabled = true;
        private long startDelay = 10000;
        private long repeatInterval = 60000;

        private String appId = "cas-ticket-registry-cleaner";

        public String getAppId() {
            return appId;
        }

        public void setAppId(final String appId) {
            this.appId = appId;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }

        public long getStartDelay() {
            return startDelay;
        }

        public void setStartDelay(final long startDelay) {
            this.startDelay = startDelay;
        }

        public long getRepeatInterval() {
            return repeatInterval;
        }

        public void setRepeatInterval(final long repeatInterval) {
            this.repeatInterval = repeatInterval;
        }
    }
}
