/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2024-2025 Vladimir Orany.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package builders.dsl.expectations.source;

public class SourceLocation {

    public static final SourceLocation UNKNOWN = new SourceLocation("Unknown", -1);

    public static SourceLocation createLocationInTheTestClass() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // Find the first stack trace element that is not from the Java standard library or this class
        StackTraceElement element = null;
        for (StackTraceElement e : stackTrace) {
            if (!e.getClassName().startsWith("java.") && !e.getClassName().startsWith("builders.dsl.expectations") || e.getClassName().endsWith("Test")) {
                element = e;
                break;
            }
        }

        if (element == null) {
            return UNKNOWN;
        }

        return new SourceLocation(element.getFileName(), element.getLineNumber());
    }

    private final String fileName;
    private final int lineNumber;

    public SourceLocation(String fileName, int lineNumber) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return String.format("(%s:%d)", fileName, lineNumber);
    }

}
