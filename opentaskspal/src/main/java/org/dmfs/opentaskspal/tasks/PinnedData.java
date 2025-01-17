/*
 * Copyright 2019 dmfs GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dmfs.opentaskspal.tasks;

import android.content.ContentProviderOperation;
import androidx.annotation.NonNull;

import org.dmfs.android.contentpal.RowData;
import org.dmfs.android.contentpal.TransactionContext;
import org.dmfs.tasks.contract.TaskContract;


/**
 * {@link RowData} for {@link TaskContract.Tasks#PINNED}
 *
 * @author Marten Gajda
 */
public final class PinnedData implements RowData<TaskContract.Tasks>
{
    private final boolean mPinned;


    public PinnedData()
    {
        this(true);
    }


    public PinnedData(boolean pinned)
    {
        mPinned = pinned;
    }


    @NonNull
    @Override
    public ContentProviderOperation.Builder updatedBuilder(@NonNull TransactionContext transactionContext, @NonNull ContentProviderOperation.Builder builder)
    {
        return builder.withValue(TaskContract.Tasks.PINNED, mPinned ? 1 : 0);
    }
}
