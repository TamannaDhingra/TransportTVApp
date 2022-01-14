package com.example.transporttvapp.model

import android.location.Location
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose




 /*class DhabaDetailModel {
     lateinit var data: Data

     class Data {

         @SerializedName("dhaba")
         @Expose
         var dhaba: Dhaba? = null

         @SerializedName("foodAmenities")
         @Expose
         var foodAmenities: Object? = null

         @SerializedName("parkingAmenities")
         @Expose
         var parkingAmenities: Object? = null


         @SerializedName("sleepingAmenities")
         @Expose
         var sleepingAmenities: Object? = null

         @SerializedName("washroomAmenities")
         @Expose
         var washroomAmenities: Object? = null

         @SerializedName("otherAmenities")
         @Expose
         var otherAmenities: Object? = null

         @SerializedName("securityAmenities")
         @Expose
         var securityAmenities: Object? = null

         @SerializedName("LightAmenities")
         @Expose
         var lightAmenities: Object? = null

         @SerializedName("owner")
         @Expose
         var owner: Owner? = null

         @SerializedName("bankDeatil")
         @Expose
         var bankDeatil: Object? = null

         @SerializedName("dhabaTiming")
         @Expose
         var dhabaTiming: List<Object>? = null;

         @JvmName("getDhaba1")
         fun getDhaba(): Dhaba? {
             return dhaba

         }


         class Dhaba {
             @SerializedName("location")
             @Expose

             var location: Location? = null

             @SerializedName("approval_for")
             @Expose
             var approvalFor: String? = null

             @SerializedName("approval_by")
             @Expose
             var approvalBy: String? = null

             @SerializedName("name")
             @Expose
             var name: String? = null

             @SerializedName("ownerName")
             @Expose
             var ownerName: String? = null

             @SerializedName("address")
             @Expose
             var address: String? = null

             @SerializedName("landmark")
             @Expose
             var landmark: String? = null

             @SerializedName("area")
             @Expose
             var area: String? = null

             @SerializedName("highway")
             @Expose
             var highway: String? = null

             @SerializedName("pincode")
             @Expose
             var pincode: String? = null

             @SerializedName("draft")
             @Expose
             var draft: List<Any>? = null

             @SerializedName("publish")
             @Expose
             var publish: List<Any>? = null

             @SerializedName("first_added")
             @Expose
             var firstAdded: Boolean? = null

             @SerializedName("isDeleted")
             @Expose
             var isDeleted: Boolean? = null

             @SerializedName("isActive")
             @Expose
             var isActive: Boolean? = null

             @SerializedName("isDraft")
             @Expose
             private var isDraft: Boolean? = null

             @SerializedName("submitForApproval")
             @Expose
             var submitForApproval: Boolean? = null

             @SerializedName("isOpen24_7")
             @Expose
             var isOpen247: Boolean? = null

             @SerializedName("_id")
             @Expose
             var id: String? = null

             @SerializedName("owner_id")
             @Expose
             var ownerId: String? = null

             @SerializedName("state")
             @Expose
             var state: String? = null

             @SerializedName("city")
             @Expose
             var city: String? = null

             @SerializedName("mobile")
             @Expose
             var mobile: String? = null

             @SerializedName("propertyStatus")
             @Expose
             var propertyStatus: String? = null

             @SerializedName("status")
             @Expose
             var status: String? = null

             @SerializedName("latitude")
             @Expose
             var latitude: String? = null

             @SerializedName("longitude")
             @Expose
             var longitude: String? = null

             @SerializedName("createdBy")
             @Expose
             var createdBy: String? = null

             @SerializedName("updatedBy")
             @Expose
             var updatedBy: String? = null

             @SerializedName("images")
             @Expose
             var images: String? = null

             @SerializedName("createdAt")
             @Expose
             var createdAt: String? = null

             @SerializedName("updatedAt")
             @Expose
             var updatedAt: String? = null

             @SerializedName("__v")
             @Expose
             var v: Int? = null

             *//* @SerializedName("dhabaObj")
    @Expose
    var dhabaObj: DhabaObj? = null*//*

             @SerializedName("isUpdated")
             @Expose
             var isUpdated: Boolean? = null

             @SerializedName("draft_by")
             @Expose
             var draftBy: String? = null

             @SerializedName("executive_id")
             @Expose
             var executiveId: String? = null

             @SerializedName("dhabaCategory")
             @Expose
             var dhabaCategory: String? = null

             @SerializedName("dhabaValue")
             @Expose
             var dhabaValue: Int? = null

             @SerializedName("blockDay")
             @Expose
             var blockDay: String? = null

             @SerializedName("blockMonth")
             @Expose
             var blockMonth: String? = null

             @SerializedName("imageList")
             @Expose
             var imageList: List<Any>? = null

             fun getIsDraft(): Boolean? {
                 return isDraft
             }

             fun setIsDraft(isDraft: Boolean?) {
                 this.isDraft = isDraft
             }
         }

     }
 }



*/


    class DhabaDetailModel {
       /* @SerializedName("status")
        var status = "200"*/

       /* @SerializedName("data")
        var data: Data? = null*/

        inner class Data {
            @SerializedName("dhaba")
            var dhaba: Dhaba? = null

            inner class Dhaba {
                @SerializedName("approval_for")
                var approval_for: String? = null

                @SerializedName("approval_by")
                var approval_by: String? = null

                @SerializedName("name")
                var name: String? = null

                @SerializedName("ownerName")
                var ownerName: String? = null

                @SerializedName("address")
                var address: String? = null

                @SerializedName("landmark")
                var landmark: String? = null

                @SerializedName("area")
                var area: String? = null

                @SerializedName("highway")
                var highway: String? = null

                @SerializedName("pincode")
                var pincode: String? = null
            }
        }
    }

