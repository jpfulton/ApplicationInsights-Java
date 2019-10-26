/*
 * ApplicationInsights-Java
 * Copyright (c) Microsoft Corporation
 * All rights reserved.
 *
 * MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the ""Software""), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.applicationinsights.agentc.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.squareup.moshi.Json;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Configuration {

    public @Nullable String connectionString;
    public @Nullable String roleName;
    public @Nullable String roleInstance;
    public Sampling sampling = new Sampling();
    public DistributedTracing distributedTracing = new DistributedTracing();
    public LiveMetrics liveMetrics = new LiveMetrics();
    public Map<String, String> telemetryContext = Collections.emptyMap();
    public List<JmxMetric> jmxMetrics = Collections.emptyList();
    public Map<String, Map<String, Object>> instrumentation = Collections.emptyMap();
    public List<CustomInstrumentation> customInstrumentation = Collections.emptyList();

    public boolean debug;
    public boolean developerMode;

    public static class Sampling {

        public @Nullable FixedRateSampling fixedRate;
    }

    public static class FixedRateSampling {

        @Json(name = "default")
        public @Nullable Double default_;
        public @Nullable Double requests;
        public @Nullable Double dependencies;
        public @Nullable Double exceptions;
        public @Nullable Double traces;
        public @Nullable Double customEvents;
        public @Nullable Double pageViews;
    }

    public static class DistributedTracing {

        public boolean outboundEnabled = true; // this can be disabled if downstream services reject extra headers
        public boolean requestIdCompatEnabled = true;
    }

    public static class LiveMetrics {

        public boolean enabled = true;
    }

    public static class JmxMetric {

        public @Nullable String objectName;
        public @Nullable String attribute;
        public @Nullable String display;
    }

    public static class CustomInstrumentation {

        public @Nullable String className;
        public @Nullable String methodName;
        public @Nullable String signature;
    }
}
