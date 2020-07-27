package com.nfood.nfood.Homescreen

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfood.nfood.Models.ItemMenuChildDto
import com.nfood.nfood.Restaurant.RestaurantDto

data class CategoryDto(val title: String, val place: String, val image: String)


class OrderProductDto {
  @SerializedName("productName")
  @Expose
  var productName: String? = null
  @SerializedName("productNote")
  @Expose
  var productNote: String? = null
  @SerializedName("productImage")
  @Expose
  var productImage: String? = null
  @SerializedName("productCost")
  @Expose
  var productCost: String? = null
  @SerializedName("productNumber")
  @Expose
  var productNumber: Int? = null
}


class SlideAdverDto {
  @SerializedName("image")
  @Expose
  var image: String? = null
  @SerializedName("url")
  @Expose
  var url: String? = null
}




class CartRestaurantDto {
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  @SerializedName("listProduct")
  @Expose
  var listProduct: ArrayList<OrderProductDto>? = null
}


class SearchResultDto {
  @SerializedName("restaurant")
  @Expose
  var restaurant : RestaurantDto? = null
  @SerializedName("listProduct")
  @Expose
  var listProduct: ArrayList<ItemMenuChildDto>? = null
}

class RestaurantOrderDto {
  @SerializedName("restaurantName")
  @Expose
  var restaurantName : String? = null
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage : String? = null
  @SerializedName("restaurantAddress")
  @Expose
  var restaurantAddress : String? = null
  @SerializedName("restaurantCash")
  @Expose
  var restaurantCash: String? = null
}

class SearchHistoryDto {
  @SerializedName("id")
  @Expose
  var id : String? = null
  @SerializedName("keyword")
  @Expose
  var keyword : String? = null
  @SerializedName("createAt")
  @Expose
  var createAt : String? = null
}