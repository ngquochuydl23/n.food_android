package com.nfood.nfood.Adapter.RecycleView

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.R

class TabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val title = itemView.findViewById<TextView>(R.id.title)
  val seeAll = itemView.findViewById<TextView>(R.id.see_all)
  val listTab = itemView.findViewById<RecyclerView>(R.id.listTab)
}

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val title = itemView.findViewById<TextView>(R.id.title)
  val numberPlace = itemView.findViewById<TextView>(R.id.place)
  val image = itemView.findViewById<ImageView>(R.id.image)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
}

class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val title = itemView.findViewById<TextView>(R.id.title)
  val subtitle = itemView.findViewById<TextView>(R.id.subtitle)
  val time = itemView.findViewById<TextView>(R.id.time)
  val avatar = itemView.findViewById<ImageView>(R.id.avatar)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
}

class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val restaurantAddress = itemView.findViewById<TextView>(R.id.restaurantAddress)
  val isVerify = itemView.findViewById<ImageView>(R.id.isVerify)
  val ratedNumber = itemView.findViewById<TextView>(R.id.ratedNumber)
  val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
}



class CartRestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val listProduct = itemView.findViewById<RecyclerView>(R.id.listProduct)
}
class CartProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val productName = itemView.findViewById<TextView>(R.id.productName)
  val productNote = itemView.findViewById<TextView>(R.id.productNote)
  val productCost = itemView.findViewById<TextView>(R.id.productCost)
  val productNumber =  itemView.findViewById<TextView>(R.id.productNumber)
  val productImage = itemView.findViewById<ImageView>(R.id.productImage)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
  val increaseClick = itemView.findViewById<View>(R.id.increaseClick)
  val decreaseClick = itemView.findViewById<View>(R.id.decreaseClick)
  val deleteClick = itemView.findViewById<View>(R.id.deleteClick)
}

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val userName = itemView.findViewById<TextView>(R.id.userName)
  val userPhone = itemView.findViewById<TextView>(R.id.userPhone)
  val userAddress = itemView.findViewById<TextView>(R.id.userAddress)
  val ward = itemView.findViewById<TextView>(R.id.ward)
  val district = itemView.findViewById<TextView>(R.id.district)
  val city = itemView.findViewById<TextView>(R.id.city)
  val addressDefault =  itemView.findViewById<CardView>(R.id.addressDefault)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
}

class PurchasesProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val productName = itemView.findViewById<TextView>(R.id.productName)
  val productNote = itemView.findViewById<TextView>(R.id.productNote)
  val productCost = itemView.findViewById<TextView>(R.id.productCost)
  val productImage = itemView.findViewById<ImageView>(R.id.productImage)
  val productNumber =  itemView.findViewById<TextView>(R.id.productNumber)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
}
class MyOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
  val idOrder = itemView.findViewById<TextView>(R.id.idOrder)
  val date = itemView.findViewById<TextView>(R.id.date)
  val listOrderRestaurant = itemView.findViewById<RecyclerView>(R.id.listOrderRestaurant)
  val deliveryStatus = itemView.findViewById<TextView>(R.id.deliveryStatus)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
  val seeMore = itemView.findViewById<TextView>(R.id.seeMore)
  val rateClick = itemView.findViewById<Button>(R.id.rate)
  val reOrderClick = itemView.findViewById<Button>(R.id.reOrder)
}
class VoucherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val voucherImage = itemView.findViewById<ImageView>(R.id.voucherImage)
  val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
}

class SearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val restaurant = itemView.findViewById<View>(R.id.restaurant)
  val restaurantName = restaurant.findViewById<TextView>(R.id.restaurantName)
  val restaurantAddress = restaurant.findViewById<TextView>(R.id.restaurantAddress)
  val isVerify = restaurant.findViewById<ImageView>(R.id.isVerify)
  val ratedNumber = restaurant.findViewById<TextView>(R.id.ratedNumber)
  val restaurantImage = restaurant.findViewById<ImageView>(R.id.restaurantImage)
}

class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val listOrderItem = itemView.findViewById<RecyclerView>(R.id.listOrderItem)
  val ship_fee = itemView.findViewById<TextView>(R.id.ship_fee)
}

class MyOrderRestaurantViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
  val restaurantAddress = itemView.findViewById<TextView>(R.id.restaurantAddress)
  val restaurantCash = itemView.findViewById<TextView>(R.id.restaurantCash)
}

class SearchHistoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
  val searchText = itemView.findViewById<TextView>(R.id.searchText)
  val searchDelete = itemView.findViewById<ImageView>(R.id.searchDelete)
}

