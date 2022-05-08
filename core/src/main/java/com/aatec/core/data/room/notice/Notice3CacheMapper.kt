/*
 * BIT Lalpur App
 *
 * Created by Ayaan on 3/17/22, 12:15 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 3/13/22, 10:36 AM
 */

package com.aatec.core.data.room.notice

import com.aatec.core.data.ui.notice.Notice3
import com.aatec.core.utils.EntityMapper
import com.aatec.core.utils.convertDateToTime
import com.aatec.core.utils.convertStringToLongMillis
import java.util.*
import javax.inject.Inject

class Notice3CacheMapper @Inject constructor() : EntityMapper<Notice3CacheEntity, Notice3> {
    override fun mapFormEntity(entity: Notice3CacheEntity): Notice3 =
        Notice3(
            title = entity.title,
            body = entity.body,
            attach = entity.attach,
            link = entity.link,
            sender = entity.sender,
            path =entity.path,
            created = entity.created.convertDateToTime()
                .convertStringToLongMillis()!!
        )

    override fun mapToEntity(domainModel: Notice3): Notice3CacheEntity =
        Notice3CacheEntity(
            domainModel.title,
            domainModel.body,
            attach = domainModel.attach,
            link = domainModel.link,
            sender = domainModel.sender,
            path = domainModel.path,
            Date(domainModel.created),
        )

    fun mapFromEntityList(entities: List<Notice3CacheEntity>): List<Notice3> =
        entities.map {
            mapFormEntity(it)
        }
}