/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ac.simons.neo4j.migrations.core.internal;

import java.lang.reflect.Constructor;

/**
 * Utilities to deal with some minor reflection tasks.
 *
 * @author Michael J. Simons
 */
public final class Reflections {

	/**
	 * Helper method for retrieving the default constructor of a given class. When such a constructor exist, it will be
	 * made accessible.
	 *
	 * @param c   The class whose constructor should be returned
	 * @param <T> The type of the class
	 * @return The default constructor
	 * @throws NoSuchMethodException If there is no such default constructr
	 */
	@SuppressWarnings("squid:S3011") // Very much the point of the whole thing
	public static <T> Constructor<T> getDefaultConstructorFor(Class<T> c) throws NoSuchMethodException {
		Constructor<T> ctr = c.getDeclaredConstructor();
		ctr.setAccessible(true);
		return ctr;
	}

	private Reflections() {
	}
}
