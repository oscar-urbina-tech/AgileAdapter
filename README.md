# AgileAdapter

Develop faster list view components for Android.

You've probably used in adapters of Android applications. Have you noticed the amount of repetitive 
code at the time of working with them again and again? You've probably worked homogeneous 
and heterogeneous views with many problems, among them validate the type of view to use 
in a huge control structure such as a 'switch' or a 'if', you've probably experienced bad practices 
such as adding listeners inside the model pattern (Holder pattern) or making api calls inside the 
custom adapter.

The AgileAdapters are a component that helps the developer to use in a more efficient manner an adapter. 
Reducing the problems of architecture and facilitating the maintenance from android applications 
with simple views like an image and a title for example until complex views with several elements
on each item view.

For this we are going to work with 3 new objects:

- ViewResolvers

The ViewResolvers objects are responsible exclusively to define the view to use.

- Populators

The populators populators objects are responsible exclusively to assign content to our components of vista.
  
- Interactors
  
The Interactors are responsible exclusively objects add interactions to our components of vista.

- AgileAdapterDTO

This object works as encapsulator of the 3 above mentioned components.

- AgileAdapter

Our main object AgileAdapter, receives in the constructor 2 parameters:  
 
   - A reference of an object that implements the interface <List> 
   - A reference to an object AgileAdapterDTO.

## How to
In order to start working with this component, first we need to define our view to work with, our ViewResolver:
 
You must create a class that extends ViewResolver, for example:

    public class ItemViewResolver extends ViewResolver{
    
    }
    
ViewResolver is an abstract class thats why now you need to override the next two methods:

    public class ItemViewResolver extends ViewResolver{
     
        /**
        * Create a holder instance.
        *
        * @param convertView the convert view
        * @return the gA banner view
        */
        @Override
        protected HolderRecycler getHolder(View convertView) {
            return new ItemHolder(convertView);
        }
        
        /**
        * Gets layout resource.
        *
        * @return the layout resource
        */
        @Override
        protected int getLayoutResource() {
            return R.layout.list_item_layout;
        }
    }

    